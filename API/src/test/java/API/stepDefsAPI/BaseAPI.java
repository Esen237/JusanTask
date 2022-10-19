package API.stepDefsAPI;

import API.DataProvider.MockDataGenerators;
import API.POJOAPI.Delete.DeleteUser;
import API.POJOAPI.GetListResourcePojo.UserListResource;
import API.POJOAPI.GetUserPojo.DataUser;
import API.POJOAPI.GetUserPojo.UserPojo;
import API.POJOAPI.GetUsersListPojo.PojoListUser;
import API.POJOAPI.PUT.PutUpdate;
import API.POJOAPI.Post.CreateUser;
import API.POJOAPI.Post.RegisterUser;

public class BaseAPI {
    MockDataGenerators mockDataGenerators = new MockDataGenerators();
    UserListResource userListResource = new UserListResource();
    PojoListUser pojoListUser = new PojoListUser();
    UserPojo userPojo = new UserPojo();
    PutUpdate putUpdate = new PutUpdate();
    RegisterUser registerUser = new RegisterUser();
    CreateUser createUser = new CreateUser();
    DeleteUser deleteUser = new DeleteUser();
}
