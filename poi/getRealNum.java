	/**
	 * 获取excel的真实行数,去掉空行等无效行:基于获取到的真实列数,减少遍历的次数
	 * @param sheet
	 * @return 行数 int
	 */
	public int getRealRowNum(Sheet sheet) {
		int RealCol=getRealCol(sheet);
		int row=0;
		//遍历所有行
        for (int i = 0; i <= sheet.getLastRowNum(); i++) { 
            Row r = sheet.getRow(i);
            int col=0;
            Boolean flag=true;
            //StringUtis.isBlank(str):str为空格 tab 换行等等空符号,返回都是true;而isEmpty
            for (int j = 0; j < RealCol; j++) {
                if(StringUtils.isBlank(getValue(r.getCell(j)))){ 
                	//最终每行的空cell数 等于 列数,那么改行为空行
                	col++;
                }else {
                	row++;
                	flag=false;
                	break;
				}
			}
            //row++之后:就不执行下面的了
            if (flag) {
            	System.out.println(col+"---"+RealCol);
	            if(col==RealCol) {
	    			break;
	    		}else {
	    			row++;
	    		}
			}
        } 
        System.out.println("总行数："+row); 
		return row;
	}