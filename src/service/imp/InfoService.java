package service.imp;

import java.util.List;

import dao.IInfoDAO;
import dao.imp.InfoDAO;
import domain.Information;
import service.IInfoService;

/**
 * Created by ki264 on 2017/2/17.
 */
public class InfoService implements IInfoService {

    private IInfoDAO infoDAO = new InfoDAO();

    @Override
    public void addInfo(Information information) {
        if (information == null)
            return;

        if (information.getId() != null)
            return;

        infoDAO.addInfo(information);
    }

    @Override
    public List<Information> getAllInfo() {
        return infoDAO.getAllInfo();
    }
}
