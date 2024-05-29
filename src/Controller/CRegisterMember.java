package Controller;
import Model.MRegisterMember;

public class CRegisterMember {
    public void registerMember(String name,String address,String email,String phone){
            MRegisterMember mrm = new MRegisterMember();
            mrm.registerMember(name, address, email, phone);
    }
}
