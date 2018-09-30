	/**
	 * 获取cell的值,输入类型为cell,自动根据cell值的类型,获取cell的值
	 * @param cell 任意类型值的cell
	 * @return
	 */
	public String getValue(Cell cell) {
		if (cell == null) {
			return "";
		} else if (cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			String value = "";
			// 检验是否为日期格式的数值类型
			if (DateUtil.isCellDateFormatted(cell)) {
				DateFormat df = DateFormat.getDateTimeInstance();
				value = df.format(cell.getDateCellValue());
			} else {
				value = new DecimalFormat("0").format(cell.getNumericCellValue());
			}
			return value;
			// String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_FORMULA) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
			return "";
		} else {
			return String.valueOf(cell.getStringCellValue());
		}
	}