import { useContext } from "react";
import { NavLink } from "react-router-dom";
import { UserContext } from "../context/UserContext";

export const UserRow = ({
  id,
  username,
  email
}) => {
  const {handlerRemoveUser, handlerUserSelectedForm} = useContext(UserContext);
  const onRemoveUser = (id) => {
    handlerRemoveUser(id);
  };

  return (
    <tr>
      <td>{id}</td>
      <td>{username}</td>
      <td>{email}</td>
      <td>
        <button
          type="button"
          onClick={() =>
            handlerUserSelectedForm({
              id,
              username,
              email,
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
    </tr>
  );
};
