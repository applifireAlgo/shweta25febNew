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
            addresstype.setAddressType("5KJI8aaw3RwWig7HPQFeFRw1ACO7ZLCjrqIkZB82r3fb8Zb03l");
            addresstype.setAddressTypeDesc("AjImsYCqvCv7LkJIp8N8gE6nUOLwpVJt6jeLPbfkFmtGbS49Ti");
            addresstype.setAddressTypeIcon("deLMiU9DzL38XNdIMp0OgoHKMqQajSg2qKdNS4XY4EaKEkx4lM");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("CVXmq9mWBeefqy6MDIBYUP2cjUd60fLq");
            city.setCityDescription("RkGfVfj60reWANhS3ZfFVfVbsWsx2xYpAwdyVt80NGZcw1RQUY");
            city.setCityFlag("8qIYRfJ79C0rLZhOaWZ1hkKaL3nxPL03ZP4ygt4wdwhDvrOW3y");
            city.setCityLatitude(2);
            city.setCityLongitude(8);
            city.setCityName("CSBU1QcbOBUUwHNHdoUXWU1g8hehTOD4ZupVIScx4jSgfjuFMP");
            Country country = new Country();
            country.setCapital("fYQAmjJxc8fND9SCBRjwW72SQo8eWq4u");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(6);
            country.setCountryCode1("Wtz");
            country.setCountryCode2("4ax");
            country.setCountryFlag("HMH7lPq8mj6LFmlTmtw7EHTathvMBBllJQTtviJtB8zt5ZmIia");
            country.setCountryName("cKnzyEyHYTAnyEZXrolKEfcvdDBAJZjGD3xSCGeisCYDeZfXDb");
            country.setCurrencyCode("cba");
            country.setCurrencyName("ndultLZMAbYkjVcdJjQ73fLblJz4JGLxAOF8XVqAIFaGmAgRkd");
            country.setCurrencySymbol("WCeyvIkkjae3ZdhYUTpN3N4AXwmCfUgi");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("bAGqWtlv747uEUStrVOGu0xWk9zdK0egqL7xoQgDUQK6UyWkXT");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("AXcU4ZgQ1o1BbtEGpKx2hnJCwfwVoGoN");
            state.setStateCodeChar3("J3BpTKPevfQhruNHIzNjCfgl9RbRhFuG");
            state.setStateDescription("1D6cRs3PO6biFhcfq44AbUAzSBKA8G8ERML8RtY868eiqTEr2k");
            state.setStateFlag("pnhwO06tdo9lhsrM4JQtfXYSslVrNiMX1Qmmjc3Ig3RvLupbI1");
            state.setStateName("ZP61rMObjloDiOkZLNsV7wJbRJBTVSHuK0pI5ESy0kfB4BCcXP");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("JvwwzLYkWz7s9nlsMmdbBcw2XffRt3un");
            city.setCityDescription("1XnZXXex32aHns09XbmCWulmibSHpnwz2SCForc48wzEfDzt78");
            city.setCityFlag("7UKIgxUi4Ss4LTx5vR3C1coySJN3AYD1UibFMPUGRIgMYGCnSE");
            city.setCityLatitude(2);
            city.setCityLongitude(1);
            city.setCityName("1KtHliDeFlJME8nqtGsmLMPxUNWO3gz1WJWZjESKnHnrJy7lC9");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("1VWOLmngi6XuwUbBvLo7qTFrscOaZh9hxCtJXfOSfPBo9f5og9");
            address.setAddress2("SWLGZQHdsmOynVgDdj5inUZvQ6BIRR2Q0sW2gCvMg07DyqKAn7");
            address.setAddress3("VdzMt5wFGCjyKpXelkhbbqStc0ZWEfOuf6oY4BskXgSgLUXWyh");
            address.setAddressLabel("v1fNxp3GATU");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("JQ3nxwcFQx5w5mGQnfVX6CzilNS63nNbq7nsyH57RxGjoPmSZx");
            address.setLongitude("H9Ko5f1PPDxiMV6sHP6ESEet3jlnlnQxQKy6LLVMj4Ry2zqIlj");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("UYCnk4");
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
            address.setAddress1("MbeDEbVSpzrDQqJ6gYRzA3PUb3WPwCq343XK0ZGhfblzdcdCQW");
            address.setAddress2("lKRX0LblW0RkgZmDfKrxvj2WWDi6vop3k34X3PpTzfeJz1EQMy");
            address.setAddress3("GVZxfe1hGhnbr7yNqKCni1t24l4s9RYoQbwOAoSrSO3Pv1KY55");
            address.setAddressLabel("on0qW1ZI0Nu");
            address.setLatitude("wXAiZmf9QH1jzrPBUw940xHtLHnK7XipDGLhxDH2ZXJOsf3P3c");
            address.setLongitude("ZGbVsms0X8ZbWiZqnNeSfX1o9T24i7JuQEyCGVRFt6R55becBz");
            address.setVersionId(1);
            address.setZipcode("laivwe");
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
