package net.datatables.wrapper.datahandle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.datatables.wrapper.AjaxRequest;
import net.datatables.wrapper.IDataHandler;
import net.datatables.wrapper.example.model.MySpecializedAcc;

public class MySpecAccDataHandler implements IDataHandler<MySpecializedAcc> {

	@SuppressWarnings("deprecation")
	@Override
	public List<MySpecializedAcc> getListData(AjaxRequest tableRequest,
			HttpServletRequest request) {
		
		List<MySpecializedAcc> listAcc = new ArrayList<>();
		listAcc.add(new MySpecializedAcc(1, "aTuanBui", new Date(), "eabcdefghijk"));
		listAcc.add(new MySpecializedAcc(2, "TauanBui", new Date(), "aebcdefghijk"));
		listAcc.add(new MySpecializedAcc(3, "TuaanBui", new Date(), "abecdefghijk"));
		listAcc.add(new MySpecializedAcc(5, "TuanaBui", new Date(), "abcdeefghijk"));
		listAcc.add(new MySpecializedAcc(6, "TuanBaui", new Date(), "abcdeefghijk"));
		listAcc.add(new MySpecializedAcc(7, "TuanBuai", new Date(), "abcdefeghijk"));
		listAcc.add(new MySpecializedAcc(8, "TuanBuia", new Date(), "abcdefgehijk"));
		listAcc.add(new MySpecializedAcc(9, "bTuanBui", new Date(), "abcdefgheijk"));
		listAcc.add(new MySpecializedAcc(10, "TbuanBui", new Date(), "abcdefghiejk"));
		listAcc.add(new MySpecializedAcc(11, "TubanBui", new Date(), "abcdefghijek"));
		listAcc.add(new MySpecializedAcc(12, "TuabnBui", new Date(), "abcdefghijke"));
		listAcc.add(new MySpecializedAcc(13, "TuanbBui", new Date(), "labcdefghijk"));
		listAcc.add(new MySpecializedAcc(14, "TuanBbui", new Date(), "albcdefghijk"));
		listAcc.add(new MySpecializedAcc(15, "TuanBubi", new Date(), "ablcdefghijk"));
		
		return listAcc;
	}

	@Override
	public int getITotalRecords() {
		return 0;
	}

	@Override
	public int getITotalDisplayRecords() {
		return 0;
	}

}
