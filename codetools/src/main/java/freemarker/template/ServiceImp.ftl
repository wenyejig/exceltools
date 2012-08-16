/**
 * @Title: ${entityName}ServiceImp.java
 * @Package com.cdxt.service.pms.imp
 * @Description: 申领单据service层实现  
 * @author 文川豪
 * @date ${date}
 * @最后修改人：文川豪
 * @最后修改时间：${date}
 * @version V1.0
 * @copyright:成都信通网易医疗科技发展有限公司
 */
package com.cdxt.service.${packageName}.imp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.cdxt.core.exception.CdxtAppException;
import com.cdxt.core.service.imp.BaseServiceImp;
 import com.cdxt.dao.${packageName}.api.${entityName}Dao;
import com.cdxt.entity.common.PageEntity;
 import com.cdxt.entity.${packageName}.${entityName};
import com.cdxt.service.${packageName}.api.${entityName}Service;

/**    
 * @ClassName: PmsNetworkClaimDServiceImp 
 * @Description: 申领单据service层实现  
 * @author 文川豪
 * @date ${date}
 * @最后修改人：文川豪
 * @最后修改时间：${date}
 * 
 * 
 */
@Repository("${entityName?uncap_first}Service")
@Transactional
public class ${entityName}ServiceImp extends BaseServiceImp<${entityName}, Serializable> implements
		${entityName}Service {

	@Resource
	${entityName}Dao ${entityName?uncap_first}Dao;

	 
	/**     
	 * @Title: save${entityName}
	 * @Description: 保存药品申领主单据的记录
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
 	 * @param entity
	 * @return 药品申领主单据
	 */
	@Override
	public ${entityName} save${entityName}(${entityName} entity) {
		 		return ${entityName?uncap_first}Dao.save(entity);
	}
	/**     
	 * @Title: delete${entityName}
	 * @Description: 删除药品申领主单据的记录
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
 	 * @param entity
	 * @return 操作是否成功
	 * @throws CdxtAppException 对方法的参数进行描述
	 */
	@Override
	public boolean delete${entityName}(${entityName} entity)
			throws CdxtAppException {
		boolean flag = true;
		try {
			${entityName?uncap_first}Dao.remove(entity);
			flag =true;
		} catch (Exception e) {
			flag = false;
			throw new CdxtAppException("", e);
		}
		return flag;
	}
	/**     
	 * @Title: delete${entityName}ByPk
	 * @Description: 根据id删除药品申领主单据的记录
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
 	 * @param pk
	 * @return 操作是否成功
	 * @throws CdxtAppException 对方法的参数进行描述
	 */
	@Override
	public boolean delete${entityName}ByPk(String pk)
			throws CdxtAppException {
		boolean flag = true;
		try {
			${entityName?uncap_first}Dao.removeByPK(pk);
			flag = true;
		} catch (Exception e) {
			flag = false;
			throw new CdxtAppException("", e);
		}
		return flag;
	}
	/**     
	 * @Title: delete${entityName}ByPks
	 * @Description: 根据ids删除药品申领主单据的记录
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
 	 * @param pks
	 * @return 操作是否成功
	 * @throws CdxtAppException 对方法的参数进行描述
	 */
	@Override
	public boolean delete${entityName}ByPks(Object[] pks)
			throws CdxtAppException {
		boolean flag = true;
		try {
			${entityName?uncap_first}Dao.remove((Serializable[]) pks);
			flag = true;
		} catch (Exception e) {
			flag = false;
			throw new CdxtAppException("", e);
		}
		return flag;
	}
	
	/**     
	 * @Title: get${entityName}ById
	 * @Description: 根据id查找药品申领主单据的记录
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
 	 * @param id
	 * @return 药品申领主单据
	 * @throws CdxtAppException 对方法的参数进行描述
	 */
	@Override
	public ${entityName} get${entityName}ById(String id)
			throws CdxtAppException {
 		return ${entityName?uncap_first}Dao.get(id);
	}
	 
	

}
