package org.ghozi.callout;

import java.util.Properties;

import org.adempiere.base.IColumnCallout;
import org.compiere.model.CalloutEngine;
import org.compiere.model.GridField;
import org.compiere.model.GridTab;
import org.compiere.model.MBPartner;
import org.compiere.model.MOrder;

public class MyCallOut extends CalloutEngine implements IColumnCallout {

	@Override
	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
		if (mField.getColumnName().equals("C_B"
				+ "Partner_ID")) {
			return this.calloutCBPartner(ctx, WindowNo, mTab, mField, value);
		}
			
		return null;
		
	}
	
	
	public String calloutCBPartner(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value) {

		Integer C_BPartner_ID = (Integer) value;
		if (C_BPartner_ID == null || C_BPartner_ID.intValue() == 0) {
			return "";
		}

	
		MBPartner bp = new MBPartner(ctx, C_BPartner_ID, null);
		
		mTab.setValue(MOrder.COLUMNNAME_Description, bp.getName2());
		
		
		
		
		return "";
	}

} 

//
//--select * from ad_org ao 
//
//--delete from ad_org 
//--where value = 'OGZ'
//
//--select * from ad_org ao 
//
//--update c_order 
//--set C_Currency_ID='303'
//--where C_Currency_ID=100

//select co.documentno ,
//co.dateordered ,
//co.grandtotal ,
//co.totallines ,
//cd."name" as nama_PO,
//cb.name as nama_cus,
//loc.address1 || ' '|| loc.address2 || ' '|| loc.address3 as bp_addrs,
//cc.iso_code as idr,
//ol.description, 
//ol.qtyordered ,
//ol.priceactual,
//ol.linenetamt,
//fnnumbertowordsid(co.grandtotal::bigint) as terbilang,
//cu."name" as UOM,
//ao."name" as nama_pt,
//ctx.taxamt as ppn,
//ctx.taxbaseamt as dpp,
//cp."name" 
//from c_order co 
//left join c_doctype cd on co.c_doctypetarget_id  = cd.c_doctype_id 
//left join  c_bpartner cb on co.c_bpartner_id = cb.c_bpartner_id 
//left join c_bpartner_location bpl on co.c_bpartner_id = bpl.c_bpartner_location_id
//left join c_location loc on bpl.c_location_id = loc.c_location_id
//left join c_currency cc on co.c_currency_id = cc.c_currency_id 
//left join c_orderline ol on co.c_order_id  = ol.c_order_id 
//left join c_uom cu on co.c_order_id  = cu.c_uom_id 
//left join ad_org ao on co.ad_org_id = ao.ad_org_id  
//left join c_ordertax ctx on co.c_order_id = ctx.c_order_id 
//left join c_paymentterm cp on co.c_order_id = cp.c_paymentterm_id 
//where co.c_order_id = 1000005
//package org.ghozi.callout;
//
//import java.util.Properties;
//
//import org.adempiere.base.IColumnCallout;
//import org.compiere.model.GridField;
//import org.compiere.model.GridTab;
//import org.compiere.model.MOrder;
//import org.compiere.util.CLogger;
//
//public class MyCallOut implements IColumnCallout {
//	
//	CLogger log = CLogger.getCLogger(MyCallOut.class);
//
//	@Override
//	public String start(Properties ctx, int WindowNo, GridTab mTab, GridField mField, Object value, Object oldValue) {
//		// TODO Auto-generated method stub
//		
//		log.warning("ColumnName: "+mField.getColumnName());
//		log.warning("NewValue: "+value.toString());
//		log.warning("OldValue: "+oldValue.toString());
//		
//		mTab.setValue(MOrder.COLUMNNAME_DocumentNo,"TesT");
//		
//		
//		return null;
//	}
//
//}
