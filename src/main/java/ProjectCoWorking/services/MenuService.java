package ProjectCoWorking.services;

import ProjectCoWorking.dao.MenuDao;
import ProjectCoWorking.models.Menu;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class MenuService {
    //--------- get menu ----------
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Menu> getMenu_JSON() {
        List<Menu> menus = MenuDao.getAllMenu();
        return menus;
    }
    //--------- get menu by id----------
    // URI:
    // contextPath/servletPath/menus/{menuId}
    @GET
    @Path("/{menuId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Menu getMenu(@PathParam("menuId") Integer menuId){
        return MenuDao.getMenu(menuId);
    }
    //--------- add menu ----------
    // URI:
    // contextPath/servletPath/menus
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Menu addMenu(Menu menu) {
        return MenuDao.addMenu(menu);
    }
    //--------- update menu ----------

    @PUT
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Menu updateMenu(Menu menu) {
        return MenuDao.updateMenu(menu);
    }
    //--------- delete menu ----------
    @DELETE
    @Path("/{menuId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteMenu(@PathParam("menuId") Integer menuId) {
        MenuDao.deleteMenu(menuId);
    }
}
