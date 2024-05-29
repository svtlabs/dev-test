import {useEffect, useState} from 'react';
import axios from 'axios';
import {useNavigate} from 'react-router-dom';
import type {People} from '../components/types';
import {endpoints} from '../components/endpoints';

const CharacterList = () => {
    const navigate = useNavigate();
    const [characters, setCharacters] = useState<People[]>([]);
    const handleClick = ({item}: { item: People }) => {
        navigate(`/detail/${item.url}`);
    };

    useEffect(() => {
        axios.get(endpoints.characters)
            .then(response => {
                setCharacters(Object.values(response.data.people));
            })
            .catch(error => {
                console.error("There was an error fetching the characters!", error);
            });
    }, []);

    return (
        <div>
            <h1>StarWars Characters</h1>
            <ul>
                {characters.map((item, index) => (
                    <li key={index} onClick={() => handleClick({item})} style={{cursor: 'pointer'}}>{item.name}</li>
                ))}
            </ul>
        </div>
    );
};

export default CharacterList;