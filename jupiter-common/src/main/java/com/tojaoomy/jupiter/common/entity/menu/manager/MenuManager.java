package com.tojaoomy.jupiter.common.entity.menu.manager;

import com.tojaoomy.jupiter.common.entity.authentication.Token;
import com.tojaoomy.jupiter.common.entity.menu.Button;
import com.tojaoomy.jupiter.common.entity.menu.ClickButon;
import com.tojaoomy.jupiter.common.entity.menu.ComplexButton;
import com.tojaoomy.jupiter.common.entity.menu.Menu;
import com.tojaoomy.jupiter.common.util.CommonUtil;
import com.tojaoomy.jupiter.common.util.MenuUtil;

/**
 * @author hejian
 *
 *  @date 2014年9月22日
 */
public class MenuManager {
    public static Menu getMenu(){
        ClickButon btn11 = new ClickButon();
        btn11.setName("我的车享");
        btn11.setKey("saic_of_mine");
        
        ClickButon btn12 = new ClickButon();
        btn12.setName("我的询价");
        btn12.setKey("inquiry");
        
        ClickButon btn13 = new ClickButon();
        btn13.setName("我的试驾");
        btn13.setKey("test_drive");
        
        ClickButon btn14 = new ClickButon();
        btn14.setName("我的保养");
        btn14.setKey("maintenance");
        
        ClickButon btn21 = new ClickButon();
        btn21.setName("车查询");
        btn21.setKey("car_query");
        
        ClickButon btn31 = new ClickButon();
        btn31.setName("客服电话");
        btn31.setKey("service_phone");
        
        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("我的车享");
        mainBtn1.setSub_button(new Button[]{btn11,btn12,btn13});
        
        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("享购车");
        mainBtn2.setSub_button(new Button[]{btn21});
        
        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("帮助");
        mainBtn3.setSub_button(new Button[]{btn31});
        
        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1,mainBtn2,mainBtn3});
        
        return menu;
    }
    
    public static void main(String[] args) {
        Token token = CommonUtil.getAccessToken("wx38a0b3a7cc7761f9", "04a4ea410735b9a134d41ed29ce64699");
        if(token != null){
            int result = MenuUtil.createMenu(getMenu(), token.getToken());
            if(result == 0){
                System.out.println("创建菜单成功");
            }else{
                System.out.println("创建菜单失败");
            }
        }
    }
}
