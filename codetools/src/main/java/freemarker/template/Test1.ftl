
	public ${className} save${className}(${className} entity);
	
	public boolean delete${className}(${className} entity) throws CdxtAppException;
	
	public boolean delete${className}ByPk(String pk)throws CdxtAppException;
	
	public boolean delete${className}ByPks(Object[] pks)throws CdxtAppException;
	
	public ${className} get${className}ById(String id) throws CdxtAppException;
	
	public List<${className}> find${className}ListByHql(String hql)
			throws CdxtAppException;

	public PageEntity find${className}PageList(String hqlWhere, int startPage,
			int pageSize) throws CdxtAppException;

	

