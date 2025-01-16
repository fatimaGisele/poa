package poa.poa_demo.Services;

import org.springframework.stereotype.Service;

@Service
public class SaludadorService implements ISaludadorService{

    @Override
    public String Saludar(String p, String frase) {
        String s= frase+" "+p;
        System.out.println(s);
        return s;
    }

    @Override
    public String SaludarError(String p, String frase) {
        throw new RuntimeException("error");
    }

}
