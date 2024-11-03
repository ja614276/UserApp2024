import axios from "axios"
import usersApi from "../apis/usersApi.js";

/*
//funcion reemplazada por userApi
const BASE_URL = 'http://localhost:8080/users';
const config = () => {
    return {
        headers: {
            "Authorization": sessionStorage.getItem('token'),
            "Content-Type": "application/json",
        }
    }
}
*/

const BASE_URL = '';

export const findAll = async () => {
    try {
        const response = await usersApi.get(BASE_URL);
        return response;
    } catch (error) {
        console.error(error);
    }
    return null;
}

export const save = async ({username, email, password, admin}) => {
    try {
        return await usersApi.post(BASE_URL, {
            username,
            email,
            password,
            admin,
        });
    } catch (error) {
        throw error;
    }
}

export const update = async ({id, username, email, admin}) => {
    try {
        return await usersApi.put(`${BASE_URL}/${id}`, {
            username,
            email,
            // password: 'nothing',
            admin,
        });
    } catch (error) {
        throw error;
    }
}

export const remove = async (id) => {
    try {
        await usersApi.delete(`${BASE_URL}/${id}`, config());
    } catch (error) {
        console.error(error);
        throw error;
    }
}