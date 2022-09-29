package com.example.springbootlayui.test;

import com.example.springbootlayui.dao.SaleChanceMapper;
import com.example.springbootlayui.dao.UserMenuMapper;
import com.example.springbootlayui.entity.UserMenu;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class test {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Resource
    private SaleChanceMapper saleChanceMapper;

    @Test
    public void testMenu() {
        List<UserMenu> userMenu = userMenuMapper.getUserMenu(1);

        System.out.println("userMenu = " + userMenu);
    }

    @Test
    public void testSale() {
        System.out.println("saleChanceMapper.getAll() = " + saleChanceMapper.getAll());
    }

    @Test
    public void testMenuList() {
        //List<UserMenu> data =new ArrayList<>();
        //按照pid获取到根目录进行存储对应的子目录
        List<UserMenu> navId = userMenuMapper.getUserMenu(4);
        for (UserMenu nav : navId) {
            //子节点的pid为父节点的id，根据父节点id查到其所有子节点
            List<UserMenu> navigationListByPId = userMenuMapper.getMenu(nav.getId());
            nav.setTitleNode(navigationListByPId);
        }
        System.out.println("navId = " + navId);
    }
}

