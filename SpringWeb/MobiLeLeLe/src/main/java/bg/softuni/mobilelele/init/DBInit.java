package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.model.entity.*;
import bg.softuni.mobilelele.model.entity.enums.Category;
import bg.softuni.mobilelele.model.entity.enums.Engine;
import bg.softuni.mobilelele.model.entity.enums.Role;
import bg.softuni.mobilelele.model.entity.enums.Transmission;
import bg.softuni.mobilelele.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Component
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final BrandRepository brandRepository;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository, ModelRepository modelRepository, OfferRepository offerRepository, BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initUsers();
        initBrands();
        initModels();
        initOffers();
    }

    public void initBrands() {

        if (brandRepository.count() == 0) {
            Brand brand1 = new Brand();
            Brand brand2 = new Brand();

            brand1.setName("Honda");
            brand2.setName("Opel");

            brandRepository.saveAll(List.of(brand1, brand2));
        }

    }

    public void initModels() {

        if (modelRepository.count() == 0) {
            Model model1 = new Model();
            Model model2 = new Model();
            Model model3 = new Model();
            Model model4 = new Model();

            model1.setBrand(brandRepository.findByName("Honda"));
            model1.setCategory(Category.CAR);
            model1.setName("CR-V");
            model1.setImageUrl("https://i.ibb.co/236gj2N/63cb9d75e90c0162bd038cf2o.jpg");

            model2.setBrand(brandRepository.findByName("Opel"));
            model2.setCategory(Category.TRUCK);
            model2.setName("Movano");
            model2.setImageUrl("https://i.ibb.co/qJJCcqk/633edc776473c49c050e2243o.jpg");

            model3.setBrand(brandRepository.findByName("Honda"));
            model3.setCategory(Category.MOTORCYCLE);
            model3.setName("X-ADV");
            model3.setImageUrl("https://i.ibb.co/mBS29R8/63a9ec7028ea69b62a0bdf02o.jpg");

            model4.setBrand(brandRepository.findByName("Opel"));
            model4.setCategory(Category.BUSS);
            model4.setName("Vivaro");
            model4.setImageUrl("https://i.ibb.co/KrbBp9M/637ca80864083a21ba0a2b03o.jpg");

            modelRepository.saveAll(List.of(model1, model2, model3, model4));
        }


    }

    public void initOffers() {
        if (offerRepository.count() == 0) {
            Offer offer1 = new Offer();
            Offer offer2 = new Offer();
            Offer offer3 = new Offer();
            Offer offer4 = new Offer();

            offer1.setModel(modelRepository.findByName("CR-V"));
            offer1.setEngine(Engine.GASOLINE);
            offer1.setTransmission(Transmission.AUTOMATIC);
            offer1.setMileage(22500);
            offer1.setPrice(BigDecimal.valueOf(14300));
            offer1.setYear(2007);
            offer1.setDescription("Used, but well service and in good condition.");
            offer1.setSeller(userRepository.findByUsername("tanya").orElse(null));
            offer1.setImageUrl(modelRepository.findByName("CR-V").getImageUrl());
            offer1.setCreated(Instant.now());

            offer2.setModel(modelRepository.findByName("Movano"));
            offer2.setEngine(Engine.DIESEL);
            offer2.setTransmission(Transmission.MANUAL);
            offer2.setMileage(300231);
            offer2.setPrice(BigDecimal.valueOf(12000));
            offer2.setYear(2001);
            offer2.setDescription("Old, but gold!");
            offer2.setSeller(userRepository.findByUsername("admin").orElse(null));
            offer2.setImageUrl(modelRepository.findByName("Movano").getImageUrl());
            offer2.setCreated(Instant.now());

            offer3.setModel(modelRepository.findByName("Vivaro"));
            offer3.setEngine(Engine.HYBRID);
            offer3.setTransmission(Transmission.AUTOMATIC);
            offer3.setMileage(1000);
            offer3.setPrice(BigDecimal.valueOf(35000));
            offer3.setYear(2022);
            offer3.setDescription("The best in the market");
            offer3.setSeller(userRepository.findByUsername("tanya").orElse(null));
            offer3.setImageUrl(modelRepository.findByName("Vivaro").getImageUrl());
            offer3.setCreated(Instant.now());

            offer4.setModel(modelRepository.findByName("X-ADV"));
            offer4.setEngine(Engine.ELECTRIC);
            offer4.setTransmission(Transmission.MANUAL);
            offer4.setMileage(2050);
            offer4.setPrice(BigDecimal.valueOf(7500));
            offer4.setYear(2018);
            offer4.setDescription("Chicks magnet");
            offer4.setSeller(userRepository.findByUsername("vesko").orElse(null));
            offer4.setImageUrl(modelRepository.findByName("X-ADV").getImageUrl());
            offer4.setCreated(Instant.now());


            offerRepository.saveAll(List.of(offer1, offer2, offer3, offer4));
        }


    }

    public void initUsers() {

        if (userRoleRepository.count() == 0) {
            UserRole adminRole = new UserRole();
            adminRole.setName(Role.ADMIN);
            userRoleRepository.save(adminRole);

            UserRole userRole = new UserRole();
            userRole.setName(Role.USER);
            userRoleRepository.save(userRole);
        }

        if (userRepository.count() == 0) {
            UserRole adminRole = userRoleRepository.findByName(Role.ADMIN);
            UserRole userRole = userRoleRepository.findByName(Role.USER);

            User admin = new User();

            admin
                    .setActive(true)
                    .setUsername("admin")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword(passwordEncoder.encode("test"))
                    .setCreated(Instant.now())
                    .setRoles(Set.of(adminRole, userRole));

            userRepository.save(admin);

            User user = new User();

            user
                    .setActive(true)
                    .setUsername("vesko")
                    .setFirstName("Veselin")
                    .setLastName("Hristov")
                    .setPassword(passwordEncoder.encode("1234"))
                    .setRoles(Set.of(userRole));

            userRepository.save(user);

            User user1 = new User();

            user1
                    .setActive(true)
                    .setUsername("tanya")
                    .setFirstName("Tanya")
                    .setLastName("Hristova")
                    .setPassword(passwordEncoder.encode("1234"))
                    .setRoles(Set.of(userRole));

            userRepository.save(user1);

        }
    }
}
