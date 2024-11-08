import {useContext} from "react";
import {UserRow} from "./UserRow";
import {UserContext} from "../context/UserContext";
import {AuthContext} from "../auth/context/AuthContext.jsx";

export const UserList = () => {
    const {users} = useContext(UserContext);
    const {login} = useContext(AuthContext);
    return (
        <table className="table table-hover table-striped">
            <thead>
            <tr>
                <th>#</th>
                <th>Username</th>
                <th>Email</th>
                {!login.isAdmin || <>
                    <th>Update</th>
                    <th>Update route</th>
                    <th>Remove</th>
                </>}
            </tr>
            </thead>
            <tbody>
            {users.map(({id, username, email, admin}) => (
                <UserRow
                    key={id}
                    id={id}
                    username={username}
                    email={email}
                    admin={admin}
                />
            ))}
            </tbody>
        </table>
    );
};

