package net.datatables.wrapper.datahandle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.datatables.wrapper.AjaxRequest;
import net.datatables.wrapper.IDataHandler;
import net.datatables.wrapper.example.model.UserAccount;

public class UserAccDataHandler implements IDataHandler<UserAccount> {

	@Override
	public List<UserAccount> getListData(AjaxRequest tableRequest,
			HttpServletRequest request) {
		List<UserAccount> listAcc = new ArrayList<>();
		listAcc.add(new UserAccount(1, "aTuanBui", new Date(), "gf"));
		listAcc.add(new UserAccount(2, "TauanBui", new Date(), "h"));
		listAcc.add(new UserAccount(3, "TuaanBui", new Date(), "rt"));
		listAcc.add(new UserAccount(4, "TuaanBui", new Date(), "df"));
		listAcc.add(new UserAccount(5, "TuanaBui", new Date(), "df"));
		listAcc.add(new UserAccount(6, "TuanBaui", new Date(), "hr"));
		
		return listAcc;
	}

	/**
	 * return total records from database if table defined bServerSide = true
	 */
	@Override
	public int getITotalRecords() {
		return 0;
	}

	
	/**
	 * return total records from database after filtered.
	 */
	@Override
	public int getITotalDisplayRecords() {
		return 0;
	}

}
