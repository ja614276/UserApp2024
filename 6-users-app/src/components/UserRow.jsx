import {useContext} from "react";
import {NavLink} from "react-router-dom";
import {UserContext} from "../context/UserContext";
import {AuthContext} from "../auth/context/AuthContext.jsx";

export const UserRow = ({
                            id,
                            username,
                            email,
                            admin
                        }) => {
    const {handlerRemoveUser, handlerUserSelectedForm} = useContext(UserContext);
    const {login} = useContext(AuthContext);
    const onRemoveUser = (id) => {
        handlerRemoveUser(id);
    };

    return (
        <tr>
            <td>{id}</td>
            <td>{username}</td>
            <td>{email}</td>

            {!login.isAdmin || <>
                <td>
                    <button
                        type="button"
                        onClick={() =>
                            handlerUserSelectedForm({
                                id,
                                username,
                                email,
                                admin,
                            })
                        }
                        className="btn btn-secondary btn-sm"
                    >
                        Editar
                    </button>
                </td>

                <td>
                    <NavLink
                        className={"btn btn-secondary btn-sm"}
                        to={"/users/edit/" + id}
                    >
                        update route
                    </NavLink>
                </td>

                <td>
                    <button
                        type="button"
                        onClick={() => onRemoveUser(id)}
                        className="btn btn-danger btn-sm"
                    >
                        Eliminar
                    </button>
                </td>
            </>}

        </tr>
    );
};
