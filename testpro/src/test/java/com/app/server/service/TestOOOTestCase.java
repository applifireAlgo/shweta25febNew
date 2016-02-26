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
            address.setAddress1("4q7ehWsf6DNvWN2DAGT2eolxn8KT3PNI8Tdtft2OimYeDzqmqb");
            address.setAddress2("yViuS22Uo4X4CO78iUB8YEmDv0peFFzQwuhKaQ1e3cK6PBblkQ");
            address.setAddress3("SScewSMav0iXNREhg3NwdmGlhbRV0qmDBdsFU2B2JFllSJA8n1");
            address.setAddressLabel("OzowPpQJ0jz");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("vAfDc4liNurNVwXbM6JmiCDCkDlmE1EpHM4PzFIBAFSJbq62DT");
            addresstype.setAddressTypeDesc("02s7PP6UZCjoSfxAanmwecM197pWXTfgKobWRBq7ezVYjL9M3t");
            addresstype.setAddressTypeIcon("S8LgpHUR7OoO8CMuQFUCNobXoAykijWxQwocMPMxz9wnap2ZqU");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("0Q34ZFSYlb8LaZyplcL0o8nNnivI8owM");
            city.setCityDescription("pZUUN9OCHYQr55Axk2wXxd5JMVzYChm1b1PkXyi5fta1QF3fxS");
            city.setCityFlag("gE4MtfFbRPvofjohSq4DStBFcrxQ5vDxV9PorweyuQArZR9Qdo");
            city.setCityLatitude(10);
            city.setCityLongitude(7);
            city.setCityName("F2gunGbJ5zqmOOfCZGpdaEIMvMHsgFWYkmXJQnPMmQU7h9ndN4");
            Country country = new Country();
            country.setCapital("VvPbQmGCFHUzNijNWLfSmYicUccfMExP");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(11);
            country.setCountryCode1("qoM");
            country.setCountryCode2("VSf");
            country.setCountryFlag("JU63wMNUfQWf3vydruJUUuQUK5WYeyiGMHtxlgDwPyGcoeeBVi");
            country.setCountryName("OQTH6f3jQBdBKRLVXeeeZAWgXo7CY2ee7IS1CQS4espX9KJ4Fx");
            country.setCurrencyCode("z47");
            country.setCurrencyName("eP6PC4FOcTprdwpD2zWw0SZ1IAlUKnjIH13RPdWuQo52UlUrlN");
            country.setCurrencySymbol("awF7nyh8uJqFvCJAzo17jm5Y8pJghULW");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("JSdtbtdmQbgKk3Ymr3L9qs5LmygEjoDcfdRaaVcQpZ643tZN1Z");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(7);
            state.setStateCode(2);
            state.setStateCodeChar2("n5i6Snl1MHzRll5z8zFGQ4TpAp0e9YXX");
            state.setStateCodeChar3("6eBbplZhoIX1xwuVukVnbBxGj6Xlapd0");
            state.setStateDescription("pT9bWjMsq0itUGgOXqgWDHR1AZDoIKby8fDYI1INZhKN7on7w4");
            state.setStateFlag("5HQ0OaXk7tI0juZ8i0dZBgi6MtSmr6Qr0aAlIuEF7yGdVB51ib");
            state.setStateName("zckF7ysF13CWL4aiZWJOKRx1yBF05HfCb8vtc2d5h0FnGNrRdv");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("hhh69JexmV3zOW8IQg2KmePNFDjcZF87");
            city.setCityDescription("2R1m9fT1GBeXrGgMGGvviixqDWAw9zv1CGegys1PNxnPfnPEpP");
            city.setCityFlag("1BQSqr8XEKkhqcjpEozqtTPEsdjmOp6iW5IVzUkV0o0iETGFDy");
            city.setCityLatitude(2);
            city.setCityLongitude(7);
            city.setCityName("H9pz6FdkRzSnuHEZqdTUvZKMh1IFQjL6p7dhqn39a3IHNnctR9");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("cK9dFVBWghnXvhyPJkrhXSyqeS4qCA92Eca7Psl0m7HDa7x0f3");
            address.setAddress2("kK6F2jBrAs2Q4jKvUoooWIoocigNID7jBs8QCVcFHrOZ8l2bPE");
            address.setAddress3("ErjisdGNZZRfooMtCzjhhSNCd7PPLLDwesMR131JE1NMuJxcyN");
            address.setAddressLabel("zVw6xfjTMhf");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("bJQNE9VGxzxgKZ4rtkCh6MUt5HEOoZht9qjuYK8h5fGHlYoYEx");
            address.setLongitude("EHY0dkyclSa6te9YDQzOVD9MehwnpPZaOgGjDAdN2ASMbeGake");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("qLiR0w");
            TestOOO testooo = new TestOOO();
            testooo.setAddress(addressRepository.save(address));
            map.put("AddressPrimaryKey", address._getPrimarykey());
            testooo.setDsds("Q7QuigQuV1Vrr81AhlRYwVJAHx7Duns7fjj6z2uWkNOIsgUzso");
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
            testooo.setDsds("IS9zgz5tr2Li8cHZMLMNAeNTwXtSXRf9AIusEoq70LCxynAizz");
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
