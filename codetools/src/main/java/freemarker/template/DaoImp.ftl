/**
 * @Title: ${entityName}DaoImp.java
 * @Package com.cdxt.dao.pms.imp
 * @Description: TODO文(用一句话描述该文件做什么)
 * @author 文川豪
 * @date ${date}
 * @最后修改人：文川豪
 * @最后修改时间：${date}
 * @version V1.0
 * @copyright:成都信通网易医疗科技发展有限公司
 */
package com.cdxt.dao.${packageName}.imp;

import java.io.Serializable;
import org.springframework.stereotype.Repository;

import com.cdxt.core.dao.imp.BaseDaoImp;
import com.cdxt.dao.${packageName}.api.${entityName}Dao;
import com.cdxt.entity.${packageName}.${entityName};

/**    
 * @ClassName: ${entityName}DaoImp 
 * @Description: TODO文(这里用一句话描述这个类的作用) 
 * @author 文川豪
 * @date ${date}
 * @最后修改人：文川豪
 * @最后修改时间：${date}
 * 
 * 
 */
@Repository("${entityName?uncap_first}Dao")
public class ${entityName}DaoImp extends BaseDaoImp<${entityName}, Serializable> implements
		${entityName}Dao {



}
