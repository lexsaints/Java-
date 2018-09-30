	/**
	 * 通过第一行,默认为行头:标题行的cell不能为空
	 * @param excel表格的sheet页面
	 * @return
	 */
	public int getRealCol(Sheet sheet) {
		//使用行头判断
		Row row = sheet.getRow(0);
		String val=row.getCell(1).getStringCellValue();
		int cells = row.getLastCellNum();//获得列数
		int cols=0;
        for(Cell c:row){ 
        	if (StringUtils.isBlank(getValue(c))) {
				
			}else {
				cols++;
			}
        } 
        System.out.println("包含数据的真实列数："+cols); 
		return cols;
	}