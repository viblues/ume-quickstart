package org.umeframework.quickstart.uac.entity.crud.impl;

import java.util.List;
import java.util.Map;
import org.umeframework.quickstart.uac.entity.UmeResourceDto;
import org.umeframework.quickstart.uac.entity.crud.UmeResourceCrudService;

/**
 * UME资源管理表:UME_RESOURCE CRUD service implementation.<br>
 *
 * @author UME-Generator
 */
@org.springframework.stereotype.Service
public class UmeResourceCrudServiceImpl extends org.umeframework.dora.service.BaseDBComponent implements UmeResourceCrudService {

    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#create
     */
    @Override
    public Integer create(UmeResourceDto entity) {
        validate(entity);
        if (entity.getCreateAuthor() == null) {
            entity.setCreateAuthor(getUid());
        }
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(getUid());
        }
        int result = getDao().update(UmeResourceDto.SQLID.INSERT, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#createList
     */
    @Override
    public List<Integer> createList(List<UmeResourceDto> entityList) {
        List<Integer> result = new java.util.ArrayList<Integer>(entityList.size());
        for (UmeResourceDto entity : entityList) {
            result.add(this.create(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#createOrUpdate
     */
    @Override
    public Integer createOrUpdate(UmeResourceDto entity) {
        UmeResourceDto existed = getDao().queryForObject(UmeResourceDto.SQLID.FIND, entity, UmeResourceDto.class);
        if (existed == null) {
            return this.create(entity);
        } else {
            validate(entity);
            return this.update(entity);
        }
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#createOrUpdateList
     */
    @Override
    public List<Integer> createOrUpdateList(List<UmeResourceDto> entityList) {
        List<Integer> result = new java.util.ArrayList<Integer>(entityList.size());
        for (UmeResourceDto entity : entityList) {
            result.add(this.createOrUpdate(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#update
     */
    @Override
    public Integer update(UmeResourceDto entity) {
        validate(entity);
        if (entity.getUpdateAuthor() == null) {
            entity.setUpdateAuthor(getUid());
        }
        int result = getDao().update(UmeResourceDto.SQLID.UPDATE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#updateList
     */
    @Override
    public List<Integer> updateList(List<UmeResourceDto> entityList) {
        List<Integer> result = new java.util.ArrayList<Integer>(entityList.size());
        for (UmeResourceDto entity : entityList) {
            result.add(this.update(entity));
        }
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#delete
     */
    @Override
    public Integer delete(UmeResourceDto entity) {
        int result = getDao().update(UmeResourceDto.SQLID.DELETE, entity);
        return result;
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#deleteList
     */
    @Override
    public List<Integer> deleteList(List<UmeResourceDto> entityList) {
        List<Integer> result = new java.util.ArrayList<Integer>(entityList.size());
        for (UmeResourceDto entity : entityList) {
            result.add(this.delete(entity));
        }
        return result;
    }

    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#find
     */
    @Override
    public UmeResourceDto find(UmeResourceDto queryParam) {
        return getDao().queryForObject(UmeResourceDto.SQLID.FIND, queryParam, UmeResourceDto.class);
    }
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#findList
     */
    @Override
    public List<UmeResourceDto> findList(UmeResourceDto condition) {
        return getDao().queryForObjectList(UmeResourceDto.SQLID.FIND_LIST, condition, UmeResourceDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService#findListLike
     */
    @Override
    public List<UmeResourceDto> findListLike(Map<String, String> condition) {
        return getDao().queryForObjectList(UmeResourceDto.SQLID.FIND_LIST_LIKE, condition, UmeResourceDto.class);
    }
    
    /* (non-Javadoc)
     * 
     * @see org.umeframework.quickstart.uac.entity.crud.impl.UmeResourceCrudService
     */
    @Override
    public Integer count(Map<String, String> condition) {
        return getDao().count(UmeResourceDto.SQLID.COUNT, condition);
    }

    /**
     * Do entity validation before doUpdate
     * 
     * @param entity - Target doUpdate Entity
     */
    protected void validate(UmeResourceDto entity) {
        // Here invoke the default entity check logic
        org.umeframework.dora.bean.BeanValidator beanValidator = new org.umeframework.dora.bean.BeanValidator();
        // Invoke validation rule
        beanValidator.validate(entity);
    }
}
