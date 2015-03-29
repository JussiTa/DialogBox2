package fi.isokaju.DialogBox2.dao;

import fi.isokaju.DialogBox2.model.Peugeot;

public interface PeugeotDao {

	public void addModel(Peugeot p) throws Exception;

	public void updateModel(Peugeot p);

	public Peugeot[] getModel();

}
