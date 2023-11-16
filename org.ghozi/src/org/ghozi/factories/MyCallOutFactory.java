package org.ghozi.factories;

import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.IColumnCallout;
import org.adempiere.base.IColumnCalloutFactory;
import org.compiere.model.I_C_Order;
import org.ghozi.callout.MyCallOut;

/**
 * 
 * @author Tegar N
 *
 */

public class MyCallOutFactory implements IColumnCalloutFactory {

	@Override
	public IColumnCallout[] getColumnCallouts(String tableName,
			String columnName) {

		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
		
		if (tableName.equals(I_C_Order.Table_Name)){
			list.add (new MyCallOut());
		}
		
//		else if (tableName.equals(I_M_InOut.Table_Name)){
//			list.add (new GHZ_CalloutShipment());
//		}
//		
		return list != null ? list.toArray(new IColumnCallout[0])
				: new IColumnCallout[0];
	}

}

//package org.ghozi.factories;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.adempiere.base.IColumnCallout;
//import org.adempiere.base.IColumnCalloutFactory;
//import org.compiere.model.MOrder;
//import org.ghozi.callout.MyCallOut;
//
//public class MyCallOutFactory implements IColumnCalloutFactory {
//
//	@Override
//	public IColumnCallout[] getColumnCallouts(String tableName, String columnName) {
//		// TODO Auto-generated method stub
//		
//		List<IColumnCallout> list = new ArrayList<IColumnCallout>();
//		
//		if(tableName.equalsIgnoreCase(MOrder.Table_Name) && columnName.equalsIgnoreCase(MOrder.COLUMNNAME_Description))
//			list.add(new MyCallOut());
//		
//		if(tableName.equalsIgnoreCase(MOrder.Table_Name) && columnName.equalsIgnoreCase(MOrder.COLUMNNAME_AD_Org_ID))
//			list.add(new MyCallOut());
//		
//		return list != null ? list.toArray(new IColumnCallout[0]): new IColumnCallout[0];
//	}
//
//}
