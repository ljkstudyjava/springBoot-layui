package com.example.springbootlayui.service.Impl;

import com.example.springbootlayui.dao.UserMenuMapper;
import com.example.springbootlayui.entity.UserMenu;
import com.example.springbootlayui.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private UserMenuMapper userMenuMapper;

    @Override
    public Map<String, Object> findMenu(Integer id) {
        Map<String, Object> data = new HashMap<>();
        //按照pid获取到根目录进行存储对应的子目录
        List<UserMenu> navId = userMenuMapper.getUserMenu(id);
        for (UserMenu nav : navId) {
            //子节点的pid为父节点的id，根据父节点id查到其所有子节点
            List<UserMenu> navigationListByPId = userMenuMapper.getMenu(nav.getId());
            nav.setTitleNode(navigationListByPId);
        }
        data.put("menu", navId);
        return data;
    }
}
