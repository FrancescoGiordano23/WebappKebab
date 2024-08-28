package com.advancia.soap;

import evg.jax_ws_bu.entity.Models;
import evg.jax_ws_bu.entity.dao.ModelsDAO;
import java.io.IOException;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.sun.xml.ws.developer.SchemaValidation;
@WebService(serviceName = "NewWebService")
@SchemaValidation
public class NewWebService {
	

@WebMethod(operationName = "getOne")
    public Models getUserId(@WebParam(name = "id") Integer id) throws Exception {
        return modelsDao.getById(id);
}
    
    

@WebMethod(operationName = "getAll")
    public List<Models> getAll () {
        return modelsDao.getAll();
    }
     
     

@WebMethod(operationName = "addModel")
public void addmodel(
@WebParam(name = "model_name") @XmlElement(name="model_name",required=true, nillable=false) String name,
@WebParam(name = "manufacturer_id") @XmlElement(name="manufacturer_id", required=true, nillable=false) Integer manufacturerId,
@WebParam(name = "type_id") @XmlElement(name="type_id",required=true, nillable=false) Integer typeId
    ) throws Exception {
        Models model = new Models(name,manufacturerId,typeId);
        modelsDao.addModel(model);
}
    
@WebMethod(operationName = "editModel")
    public void editModel(Models model) {
        modelsDao.editModel(model);
}
    
@WebMethod(operationName = "deleteModel")
    public void deleteModel(@WebParam(name = "id_rec") Integer id_rec) throws Exception {
        modelsDao.deleteModel(id_rec);
}
