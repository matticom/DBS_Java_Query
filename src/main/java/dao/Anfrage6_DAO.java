package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Anfrage6;



public class Anfrage6_DAO {
	private EntityManager entitymanager;

	public Anfrage6_DAO(EntityManager entitymanager) {
		this.entitymanager = entitymanager;
	}

	public List<Anfrage6> anfrage6() {
		String columnName = "MM.DD";
		String QUERY_STRING = "%american idol%";
		
		Query query = entitymanager.createNativeQuery(
				"select  	ROW_NUMBER() OVER (ORDER BY aol_querydata.Date_MM_DD)  Eid,"
						+ 	"aol_querydata.Date_MM_DD,"
						+ 	"sendung.SENDUNGSNAME,"
						+ 	"aol_querydata.Suchanfragen_Menge,"
						+ 	"sendung.zuschaueranzahl As Zuschaueranzahl "
			  + "from    (	   select 	TO_CHAR(aol.querytime, 'MM.DD') As Date_MM_DD,"
									 + "count(TO_CHAR(aol.querytime, 'MM.DD')) As Suchanfragen_Menge "
							+ "from AOLDATA.querydata aol "
							+ "where aol.query like '%american idol%' "
							+ "Group by TO_CHAR(aol.querytime, 'MM.DD') "
					  + ") 	aol_querydata "
			  + "inner join sendung "
			  + "on TO_CHAR(sendung.AIR_DATE, 'MM.DD') = aol_querydata.Date_MM_DD "
			  + "order by aol_querydata.Date_MM_DD", Anfrage6.class);
		//		query.setParameter(1, columnName);
//		query.setParameter(2, QUERY_STRING);
		System.out.println(query);
		return query.getResultList();
	}
}