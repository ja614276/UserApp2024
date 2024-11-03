import {Navigate, Route, Routes} from "react-router-dom";
import {UsersPage} from "../pages/UsersPage";
import {Navbar} from "../components/layouts/Navbar";
import {RegisterPage} from "../pages/RegisterPage";
import {UserProvider} from "../context/UserProvider";
import {useContext} from "react";
import {AuthContext} from "../auth/context/AuthContext.jsx";
//import{useUsers} from "../hooks/useUsers";

export const UserRoutes = () => {
    const {login} = useContext(AuthContext);
    return (
        <>
            <UserProvider>
                <Navbar/>
                <Routes>
                    <Route path="users" element={<UsersPage/>}/>
                    {!login.isAdmin || <>
                        <Route path="users/register" element={<RegisterPage/>}/>
                        <Route path="users/edit/:id" element={<RegisterPage/>}/>
                    </>}

                    <Route path="/" element={<Navigate to="/users"/>}/>
                </Routes>
            </UserProvider>
        </>
    )
}
