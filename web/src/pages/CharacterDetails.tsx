import React, {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import {getImagePath} from "../components/util.ts";
import {endpoints} from "../components/endpoints.ts";
import type {People} from "../components/types.ts";
import DetailPage from "../components/DetailPage.tsx";

const CharacterDetails: React.FC = () => {
    const {id} = useParams();
    const [person, setPerson] = useState<People>();
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        const getPersonById = async () => {
            setLoading(true);
            try {
                const response = await fetch(endpoints.people(id as string));
                const result = await response.json();
                setPerson(result);
            } catch (e) {
                console.error(e);
            } finally {
                setLoading(false)
            }
        }
        getPersonById();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);
    const imagePath = getImagePath(person?.url);

    if (loading) {
        return 'loading';
    }
    if (!person) {
        return 'Person not found';
    }

    const characterDetailsConfig = {
        title: "Character",
        mainProperty: 'name',
        attributes: [
            {label: "Name", key: "name"},
            {label: "Height", key: "height"},
            {label: "Mass", key: "mass"},
            {label: "Hair color", key: "hair_color"},
            {label: "Skin color", key: "skin_color"},
            {label: "Eye color", key: "eye_color"},
            {label: "Birth year", key: "birth_year"},
            {label: "Gender", key: "gender"},
            {label: "Homeworld", key: "homeworld"},
            {label: "Created", key: "created"},
            {label: "Edited", key: "edited"},
            {label: "Url", key: "url"}
        ],
        lists: [
            {label: "Films", key: "films"},
            {label: "Species", key: "species"},
            {label: "Vehicles", key: "vehicles"},
            {label: "Starships", key: "starships"}
        ]
    };

    return (
        <DetailPage entity={person} entityDetails={characterDetailsConfig} imagePath={imagePath}/>
    )
};

export default CharacterDetails;
