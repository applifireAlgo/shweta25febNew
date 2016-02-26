package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
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
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("FiZpkQoJJuZIYgDRDbk06OovFJbA38M7Db1EwKyVk4TvWylLZx");
            addresstype.setAddressTypeDesc("dQyTwKs1mhpJdRNtIb8UnJ487riDO3WVb0ChzzLGjPG7pSMQGS");
            addresstype.setAddressTypeIcon("FFJ42qtBZ9mJqyjVAOSY53YwazsKERqfkkhMqNmAhZ3flqmrRp");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("SdMs8blwnfDaR6dyfdYOFyNJAFX8Eg5P");
            city.setCityDescription("dzKLPTCECSSQKdpFhn292GoKNPBBo7rbJNwaycRrflRNw8t31y");
            city.setCityFlag("Yo6U87KwHZzPiza9Oj02u8eMiK1ydxAcrhFpMx9w1ZkAeqYjgG");
            city.setCityLatitude(1);
            city.setCityLongitude(7);
            city.setCityName("iGvy7t4Tuq6ROUU4MW3zK5GiWL8gCVWvSpVOVYv0SCtvysFTHl");
            Country country = new Country();
            country.setCapital("B3fnrtBYP4WXy6TYthoFwJHFFGF9awkP");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(6);
            country.setCountryCode1("Xjl");
            country.setCountryCode2("J2b");
            country.setCountryFlag("HJLnKtfFH4ZNR3l79mth0L2LudCYLwJR4jLArxAckBv9rcNOAE");
            country.setCountryName("n0EpYeAc7anlFXk0eU8yCxRutXelkYY3OfegR5mjQUBFK5yOJo");
            country.setCurrencyCode("lEt");
            country.setCurrencyName("IkVXwI69XcxVZ1vxocyjpm2BNRFheZ2Cqh72dFKsN3E6BZRdoH");
            country.setCurrencySymbol("qEllih6SFDRTkj37g4B9NFq3eGtRHYav");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("3vKyabNXmxNNNBFUxwTbGVTDhKwcd120UTlAgCsuCGkq4pHfwL");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("nc0wZI5V6Am1a6wIj8cE0Jjk8noTCwfv");
            state.setStateCodeChar3("4u0NpRmmLSw0pQrTQJnClOprXfQy2xkR");
            state.setStateDescription("6cdPfkCvzbQmVETLYTPiveIxluldlAtTSQIAApB9ur2IWQ8XQd");
            state.setStateFlag("dExqA6gfweGzy1htY8CurfW39rzVcMdAt19ol1a10BTZzol2o0");
            state.setStateName("Z8GsCQ9Kj3jYx68BCGvCZQUUSGgpXAHeUx7hz5HDyZBotgMBXM");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("zkWiwUDjzeekN27gXcmnPz4qQqnAMowI");
            city.setCityDescription("RZDPLfaEaZ414DnxmbaZc2lCbiM9x2GKaVDAuJcmrzwYI9U4Kp");
            city.setCityFlag("NuH7jcXMifUIh2LB0Cbc8sFqj0hPg8SrzoqGPei4vg02weR8wO");
            city.setCityLatitude(1);
            city.setCityLongitude(4);
            city.setCityName("8gdjXDPJ0vhWX1oS7X0786esgPd56nUAkXFJxc1zcIcs1kkwxW");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("Fp9EYmSWbEstTe8tx3bJBeDEEwHMLeUjv0wF5q59sCVLea4OvY");
            address.setAddress2("btnotZSWwAO3mjjwglP9Iy8H39MRDR6LZYbMnqE3wlNHsfrDVi");
            address.setAddress3("uQXPpScRAJCASE1bbuFwuPtNtKjxD9Jbd79f1LXEw5ywXjTLp9");
            address.setAddressLabel("NBaglc3xLir");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("VyyPRl0drGPO2kUD6Afr3JiVR3O9mMxadQjnWta8mKJcik5pSQ");
            address.setLongitude("uAm4z7YtAhbwVTYx1AFEIdnUbkJaBV284w5EsB83IRUzULF4dV");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("Nw6DFl");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("DdGcD9YhdaHfih2LO2Cy0MG1ZXuPjyk63L9CzsRSxBf9dMKwuA");
            address.setAddress2("G7vzuphwbULCPGYqHZMywgvYoGFx5KCAtMZAEtIJEdXRmR9C0b");
            address.setAddress3("Mbf3TanjJmNZaDeNSzCHp9kgByWSCGvcLGMUqbNGuk5sOSa00l");
            address.setAddressLabel("OIQUmtf1nox");
            address.setLatitude("lxxepJ6Pc1FgedjfLtT3lAsqLFQqkd8go1pBowhqB7ltx9N6DI");
            address.setLongitude("ZqCcK8FA3beWhr5quRtnHOXcWHr7qXNrOFG2oQIgOyjbBu5JHh");
            address.setVersionId(1);
            address.setZipcode("ZwDPhQ");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
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
