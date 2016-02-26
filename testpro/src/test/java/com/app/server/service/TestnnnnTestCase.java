package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.TestnnnnRepository;
import com.app.shared.defaultdomain.Testnnnn;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TestnnnnTestCase {

    @Autowired
    private TestnnnnRepository<Testnnnn> testnnnnRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Address address = new Address();
            address.setAddress1("epelMmm8n4Cn4tw6j2AqIaBAx8XxvGAuMBeOgA3fbcW5TtpuMW");
            address.setAddress2("yW9FopG75c9Pu2AN6KYK2YUg933BtcoTa0dmA2e3s6OJJcwN0A");
            address.setAddress3("IarFMgi4HjnmyEm5yzCDSva4zvbcXLs58L39GnRoFKRpeNMefA");
            address.setAddressLabel("pJsykOBwRuT");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("raVMXYovdRC3tWR1vMM9zHz6IGPZA8yWnAkcLuEgJzs7njVhEE");
            addresstype.setAddressTypeDesc("TszSw0oJV6y2lcaPDz2qrVmOdQuy3F2uRGGHYkJ4alSXRX2jqb");
            addresstype.setAddressTypeIcon("vkn41nhirxfSv1eYDhIGiWZzLGqT3crRfv1Lmv7XXgh6gk8OCo");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("fuVAy9RJdDJb3251OIMzm8hMKVJC7LQ1");
            city.setCityDescription("TxGYRsXgSxQo32KW8ttk49EFMcfk7AnksR6P3KQ9TcVW56SWdL");
            city.setCityFlag("IBZw41FRsTiu9KiytYBdTu56KIpjJDY8OTUgUBkMCUTxNWm0uU");
            city.setCityLatitude(2);
            city.setCityLongitude(4);
            city.setCityName("73J9kzN9s6M1H1nUMGEp0ZjlqhCAVhbWGBxn6aiKzJEMkiNf3c");
            Country country = new Country();
            country.setCapital("FCt7WREzHSwKYIsRcj8GOCqBx7ntmeE2");
            country.setCapitalLatitude(0);
            country.setCapitalLongitude(2);
            country.setCountryCode1("8BD");
            country.setCountryCode2("2H9");
            country.setCountryFlag("SvDxRbnu1UPC63hOSf5BmZw6Lh72pKUkFB7xqeo1rXpXkRDUFu");
            country.setCountryName("fSJZmuSTvgqlasLClmM4iylixvu88dyV5Bcs4nlGYZn31hZF7c");
            country.setCurrencyCode("mXA");
            country.setCurrencyName("DrgoIJtcnP7sL4axDnSBbBDnncx1ADYyw40P9XaPSpgxNxDlep");
            country.setCurrencySymbol("MlFwpTUeHzBU9Md3BOBulktWbMzaXkxL");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("YWYkcZdq27WwycpMyNcdO26zLtW4ej4BtRHej7Y8UQP5aLchbT");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("dI5nZrnuhqrJ7vO4Nznrni2ZPQ14SI9k");
            state.setStateCodeChar3("NVYlRWOV8wogSbrRwyMZhoQCTFSLqTpt");
            state.setStateDescription("xLZxOoiegY9MUpPrzV3l4CCLLjGGyJabDjHsGt4W0XsY7Zf7pj");
            state.setStateFlag("IrXwEeigIgWNJUCCmsGTHAwmnQ7gwhYcmOswURMnPaThmNpX4Z");
            state.setStateName("gIiujPoYFVz2sLQ9JgZ0UgzJjmkO26YHYuYUWWWxxOlrmyyxVs");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("1Z3MXJIJZDBg4q0948Jt2x8IOwdtqLR3");
            city.setCityDescription("VhvcX9E7vK0C1xIjtMtMFXW1ccwPIOH8Ff58td4xrZSqk0rO1H");
            city.setCityFlag("2X7FyvfFkKtZYIblKFCWJ9ocQTnk3Rzn51csY8QWQqLoEAsvU7");
            city.setCityLatitude(2);
            city.setCityLongitude(1);
            city.setCityName("EVleEPz0O2LpijOkYlgwevHxYXWcU61KD5alNohQVFdHb59kYQ");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("4wmd8IEupeHlkyRiyxoxGy4wVnHGdcmsORDyJZ0m9FEdFM0VTK");
            address.setAddress2("QStUGlPrJ6Yr0vZUt69wVDFEnVnWjmwdMU1SrthSvaELS74FBb");
            address.setAddress3("lcNGXHD3CGYxIp5vhT1brj2Ru8ryJJPFMXAbdEycuSZCL72NaO");
            address.setAddressLabel("rXvTU1C5n4F");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("bKM87eAlyOohYjhXxuVQXwGqjAGc9Lo0KJCDdI7ilpJNdgRJmY");
            address.setLongitude("7klPolTIYoYGoCsC2ohjW8aYOcmsCp3iJDuQPYK9gp7MZdqY3s");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("FebN5e");
            Testnnnn testnnnn = new Testnnnn();
            testnnnn.setAddress(addressRepository.save(address));
            map.put("AddressPrimaryKey", address._getPrimarykey());
            testnnnn.setSfsf("HelloWorld");
            testnnnn.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testnnnn.setEntityValidator(entityValidator);
            testnnnn.isValid();
            testnnnnRepository.save(testnnnn);
            map.put("TestnnnnPrimaryKey", testnnnn._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestnnnnPrimaryKey"));
            Testnnnn testnnnn = testnnnnRepository.findById((java.lang.String) map.get("TestnnnnPrimaryKey"));
            testnnnn.setSfsf("HelloWorld");
            testnnnn.setVersionId(1);
            testnnnn.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testnnnnRepository.update(testnnnn);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestnnnnPrimaryKey"));
            testnnnnRepository.findById((java.lang.String) map.get("TestnnnnPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestnnnnPrimaryKey"));
            testnnnnRepository.delete((java.lang.String) map.get("TestnnnnPrimaryKey")); /* Deleting refrenced data */
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
