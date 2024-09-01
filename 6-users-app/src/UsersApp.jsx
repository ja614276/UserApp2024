import { LoginPage } from "./auth/pages/LoginPage";
//import { useAuth } from "./auth/hooks/useAuth";
import { UserRoutes } from "./routes/UserRouters";
import { Navigate, Route, Routes } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "./auth/context/AuthContext";

export const UsersApp = () => {
  const { login } = useContext(AuthContext);
  return (
    <Routes>
      {login.isAuth ? (
        <>
          <Route path="/*" element={<UserRoutes />} />
        </>
      ) : (
        <>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/*" element={<Navigate to="/login" />} />
        </>
      )}
    </Routes>
  );
};
