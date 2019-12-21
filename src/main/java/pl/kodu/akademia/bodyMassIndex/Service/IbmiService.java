package pl.kodu.akademia.bodyMassIndex.Service;

import pl.kodu.akademia.bodyMassIndex.Model.bodyMassIndex;

import java.util.List;

public interface IbmiService {
    void saveBmi (bodyMassIndex bodyMassIndex);
    bodyMassIndex getbodyMassIndexById(int id);
    List<bodyMassIndex>getInformWithForm();
    void updateBMI(bodyMassIndex uptateBodyMassIndex);

}
