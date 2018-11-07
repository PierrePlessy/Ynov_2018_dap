package fr.ynov.dap.dap.web;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;
import fr.ynov.dap.dap.DataStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DataStoreController {
    @Autowired
    public DataStoreService dataStoreService;

    @RequestMapping("/dataStore")
    public String dataStore(ModelMap model) throws IOException, GeneralSecurityException {
        DataStore<StoredCredential> dssc = dataStoreService.getDataStore();
        Map<String, StoredCredential> dataStoreMap = new HashMap<>();
        for (String key : dssc.keySet()) {
            dataStoreMap.put(key, dssc.get(key));
        }
        model.addAttribute("dataMap",dataStoreMap);
        return "dataStore";
    }

}
