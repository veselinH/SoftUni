package exam.service;

import exam.model.entity.Customer;

import java.io.IOException;

public interface CustomerService {

    boolean areImported();

    String readCustomersFileContent() throws IOException;

    String importCustomers() throws IOException;

    Customer findByEmail(String email);

}
