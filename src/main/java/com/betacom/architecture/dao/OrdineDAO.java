package com.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.betacom.businesscomponent.model.Ordine;

public class OrdineDAO implements  DAOConstants {
	
	private OrdineDAO() {
	}
	
	public static OrdineDAO getFactory() {
		return new OrdineDAO();
	}

	public void create(Connection conn, Ordine o) throws SQLException {
		PreparedStatement pr = conn.prepareStatement(INSERT_ORDINE);
		if(o != null) {
			pr.setDate(1, new java.sql.Date(o.getData().getTime()));
			pr.setString(2, o.getIndirizzo());
			pr.setDouble(3, o.getTotale());
			pr.setLong(4, o.getIdCliente());
			pr.execute();
		}
	}

    public void update(Connection conn, Ordine o)  {
        ProdottoDAO pDAO = ProdottoDAO.getFactory();
        
            Prodotto[] lista = pDAO.getAll(conn);
            double totale = 0;
            for (Prodotto p : lista) {
                totale += p.getPrezzo();
            }

            PreparedStatement ps;
                ps = conn.prepareStatement(UPDATE_ORDINE);
                ps.setDate(1, new java.sql.Date(o.getData().getTime()));
                ps.setString(2, o.getIndirizzo());
                ps.setDouble(3, totale);
                ps.setLong(4, o.getIdCliente());
                ps.setLong(5, o.getIdOrdine());
                ps.execute();
                conn.commit();
    }

	public void delete(Connection conn, long id) throws SQLException {
		PreparedStatement ps;

			ps = conn.prepareStatement(DELETE_ORDINE);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
	}

	public Ordine[] getAll(Connection conn) throws SQLException {
		Ordine[] ordini = null;

			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_ORDINE);
			rs.last();
			ordini = new Ordine[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Ordine o = new Ordine();
				o.setIdOrdine(rs.getLong(1));
				o.setData(new java.util.Date(rs.getDate(2).getTime()));
				o.setIndirizzo(rs.getString(3));
				o.setTotale(rs.getDouble(4));
				o.setIdCliente(rs.getLong(5));
				ordini[i] = o;
			}
			rs.close();
		return ordini;
	}
}