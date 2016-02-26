package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.TestOOORepository;
import com.app.shared.defaultdomain.TestOOO;
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
public class TestOOOTestCase {

    @Autowired
    private TestOOORepository<TestOOO> testoooRepository;

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
            address.setAddress1("cbksdilTx6awY7bI3iiBHmC6M9o2tZeucaanE1u15ssqGJ5KMe");
            address.setAddress2("IcskTTuTB86Ljfpp2244IEipE1rPDyMWPiFqDb07fgylfhS391");
            address.setAddress3("EjgfaENoi8Oh9oHxdSmT8orAy9KHrnAXmg57i3W8YKcC5CT7B6");
            address.setAddressLabel("XUUTuogFTA9");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("hPSz8cXbGMIJsgDfzkOTHNBRPIISe1Qqoc5NkkyRbyh7WqaLUq");
            addresstype.setAddressTypeDesc("4n0mU2wmuHwAvzlrHZITFlhFmXSkVOqvjYum9ErXZDjM70TJlz");
            addresstype.setAddressTypeIcon("Yw6pzXMvMVhZsdM7N4FaFoptiaNItSQpog9wBe9TYwkZhwamNz");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("biXIrkRrVR74244GEFEgRaUd1wmYtQOu");
            city.setCityDescription("jDW7q2HOSGOfb76yLYaKxuFv2nclIGgmROMaygX6HO3gyJiRlK");
            city.setCityFlag("6KZz7FiRSijdqH15KABv3CWHR1wgo4gIj4uGd2RrCz09HWHPWV");
            city.setCityLatitude(3);
            city.setCityLongitude(0);
            city.setCityName("kf2ImkdbH2dRTcKiAZFDZwLTQeVU1LBxNiUnVSE3ldporpcCZS");
            Country country = new Country();
            country.setCapital("XB9YCCzTPe7hUnoYrhyaZnx3wMJ1sXXs");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(10);
            country.setCountryCode1("Ewp");
            country.setCountryCode2("FdO");
            country.setCountryFlag("Twd2vAbLTvzdjfm20lBENbWQj7mnJYbtDJepowfkW3ApZEdZqm");
            country.setCountryName("C4gKs22ebagLuJJGZH8s0WmR85zjwMAhyGkVkgkOmnGY1H6xSC");
            country.setCurrencyCode("rxR");
            country.setCurrencyName("1qXfDtABqJr4aCYLWGsRXxS570AxBLVzWxbGYjXPEQqfhWtUn2");
            country.setCurrencySymbol("fkeUXIQ6AISgnfPApUFc65TkZw5ZBQYp");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("EwWUWl5sxoLc696b7rO6E3O4YgEt0SBMRvAtqbD4n8xIjpfxWQ");
            state.setStateCapitalLatitude(7);
            state.setStateCapitalLongitude(0);
            state.setStateCode(0);
            state.setStateCodeChar2("Ma7ypnxEDrPGBQl8azwclZ6UqEzOW64r");
            state.setStateCodeChar3("GouUQ7254zKA1WwrqoDLfK8hadJxrxpA");
            state.setStateDescription("hkowiXzoJmuAxpSi5BJS0OadeUVomcNwHSUxznPpdj8ZskSWLA");
            state.setStateFlag("9dZ2fAtnkZPYjRsfXPByAhuo4YncKmcAcmMr7RUW31wxTwKvHI");
            state.setStateName("c6lceW5cOMz6D9jjX0ykUfNF5WRvyth9nmFuM4SZirYCc4DMRV");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("YIgYdhqt5KGTwpFcmGLXBao3h8yc2gEb");
            city.setCityDescription("QsrT7eUaIlCSwrjNmhQ8HnDZNXb7rHS9HsICHaGJmAmffOe2HR");
            city.setCityFlag("8GpkVq0It5EtfAf7XUUeh4g2jhUsPmruBb6AM9muOZKGV4ac4s");
            city.setCityLatitude(11);
            city.setCityLongitude(1);
            city.setCityName("MQZNcPfmStttwJoKxdepS1gcaUj6aMknqFu3U0VDKv0ocqYA71");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("dMXyA3kiUOFrTapNC740JGrQWaUuMofuWUNFrPjWq0MZO0Lyoo");
            address.setAddress2("88DknFD6rMYJ5cDLsIRjLUVv1Pb0NRa0SifhQCfYHJf2OplIpX");
            address.setAddress3("GDTuF86XGY20kWIBz27F8kquuEF8IZMyn0U4cOdkUGxBIGwijK");
            address.setAddressLabel("zgAvL5RwL2K");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("qwkZ9bwBVii2KBJZZ2YuQXCcyNntOyyWC7bRZyG31so6jsBCPc");
            address.setLongitude("iuGVF3uvh2dIssAvkW2jdnR1DdbfvVVhsi5yRrULQV9gfTJJz9");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("j8doHM");
            TestOOO testooo = new TestOOO();
            testooo.setAddress(addressRepository.save(address));
            map.put("AddressPrimaryKey", address._getPrimarykey());
            testooo.setDsds("ZtmhiOUQ3QJ1MQXdaGH0GsriEEBHhzak2ibsLGDjHvFWzvTx3L");
            testooo.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testooo.setEntityValidator(entityValidator);
            testooo.isValid();
            testoooRepository.save(testooo);
            map.put("TestOOOPrimaryKey", testooo._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("TestOOOPrimaryKey"));
            TestOOO testooo = testoooRepository.findById((java.lang.String) map.get("TestOOOPrimaryKey"));
            testooo.setDsds("2eOrwo7RjbsNmTRCB0QoVGkE7pcYsiGOQ0WDNV8uNxMFZTMtJ4");
            testooo.setVersionId(1);
            testooo.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testoooRepository.update(testooo);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestOOOPrimaryKey"));
            testoooRepository.findById((java.lang.String) map.get("TestOOOPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestOOOPrimaryKey"));
            testoooRepository.delete((java.lang.String) map.get("TestOOOPrimaryKey")); /* Deleting refrenced data */
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
