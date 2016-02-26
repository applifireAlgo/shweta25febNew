package com.app.server.service;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.bean.ResponseBean;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import org.springframework.http.HttpEntity;
import com.app.shared.defaultdomain.NewEntity;
import com.athena.framework.server.exception.repository.SpartanTransactionException;
import java.util.List;
import com.athena.framework.server.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Service for NewEntity Master table Entity", complexity = Complexity.LOW)
public abstract class NewEntityService {

    public HttpEntity<ResponseBean> findAll() throws Exception, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(NewEntity entity) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<NewEntity> entity, boolean isArray) throws Exception, SpartanTransactionException, SpartanPersistenceException {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(NewEntity entity) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<NewEntity> entity, boolean isArray) throws SpartanTransactionException, SpartanPersistenceException, Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws SpartanPersistenceException, Exception {
        return null;
    }
}
