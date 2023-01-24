package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.enums.WarrantyType;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files
                .readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        LaptopSeedDto[] laptopSeedDtos = gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class);
        System.out.println();

        Arrays
                .stream(gson.fromJson(readLaptopsFileContent(), LaptopSeedDto[].class))
                .filter(laptopSeedDto -> {
                    boolean isValid = validationUtil.isValid(laptopSeedDto);

                    if (laptopSeedDto.getWarrantyType() == null) {
                        isValid = false;
                    }

                    Laptop laptop = findByMacAddress(laptopSeedDto.getMacAddress());

                    if (laptop != null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                    laptopSeedDto.getMacAddress(),
                                    laptopSeedDto.getCpuSpeed(),
                                    laptopSeedDto.getRam(),
                                    laptopSeedDto.getStorage())
                                    : "Invalid Laptop")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = modelMapper.map(laptopSeedDto, Laptop.class);
                    laptop.setShop(shopService.findByName(laptopSeedDto.getShop().getName()));

                    return laptop;
                })
                .forEach(laptopRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();
        for (Laptop laptop : findAllForExam()) {
            sb.append(laptop);
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Laptop findByMacAddress(String macAddress) {
        return laptopRepository
                .findByMacAddress(macAddress)
                .orElse(null);
    }

    @Override
    public List<Laptop> findAllForExam() {
        return laptopRepository.findAllForExam();
    }


}
