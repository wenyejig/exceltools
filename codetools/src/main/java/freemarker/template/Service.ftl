/**
 * @Title: ${entityName}Service.java
 * @Package com.cdxt.service.pms
 * @Description: 申领单据service层接口  
 * @author 文川豪
 * @date ${date}
 * @最后修改人：文川豪
 * @最后修改时间：${date}
 * @version V1.0
 * @copyright:成都信通网易医疗科技发展有限公司
 */
package com.cdxt.service.${packageName}.api;

import java.io.Serializable;
import java.util.List;

import com.cdxt.core.exception.CdxtAppException;
import com.cdxt.core.service.api.BaseService;
import com.cdxt.entity.common.PageEntity;
import com.cdxt.entity.${packageName}.${entityName};

/**
 * @ClassName: ${entityName}Service
 * @Description: 申领单据service层接口
 * @author 文川豪
 * @date ${date}
 * @最后修改人：文川豪
 * @最后修改时间：2011-12-21 下午02:10:01
 * 
 * 
 */
public interface ${entityName}Service extends
		BaseService<${entityName}, Serializable> {

 

	 

	/**
	 * @Title: save${entityName}
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
	 * @param entity
	 * @return 对方法的参数进行描述
	 */
	public ${entityName} save${entityName}(${entityName} entity);

	/**
	 * @Title: delete${entityName}
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
	 * @param entity
	 * @return
	 * @throws CdxtAppException
	 *             对方法的参数进行描述
	 */
	public boolean delete${entityName}(${entityName} entity)
			throws CdxtAppException;

	/**
	 * @Title: delete${entityName}ByPk
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
	 * @param pk
	 * @return
	 * @throws CdxtAppException
	 *             对方法的参数进行描述
	 */
	public boolean delete${entityName}ByPk(String pk)
			throws CdxtAppException;

	/**
	 * @Title: delete${entityName}ByPks
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
	 * @param pks
	 * @return
	 * @throws CdxtAppException
	 *             对方法的参数进行描述
	 */
	public boolean delete${entityName}ByPks(Object[] pks)
			throws CdxtAppException;



	/**
	 * @Title: get${entityName}ById
	 * @Description: TODO文(这里用一句话描述这个方法的作用)
	 * @最后修改人：文川豪
	 * @最后修改时间：${date}
	 * @param id
	 * @return
	 * @throws CdxtAppException
	 *             对方法的参数进行描述
	 */
	public ${entityName} get${entityName}ById(String id)
			throws CdxtAppException;

 

}
