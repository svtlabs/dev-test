import React, {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import {getImagePath} from "../components/util.ts";
import DetailPage from "../components/DetailPage.tsx";
import type {Planet} from "../components/types.ts";
import {endpoints} from "../components/endpoints.ts";

const planetDetailsConfig = {
    title: "Planet",
    mainProperty: 'name',
    attributes: [
        {label: "Name", key: "name"},
        {label: "Rotation Period", key: "rotation_period"},
        {label: "Orbital Period", key: "orbital_period"},
        {label: "Diameter", key: "diameter"},
        {label: "Climate", key: "climate"},
        {label: "Gravity", key: "gravity"},
        {label: "Terrain", key: "terrain"},
        {label: "Surface Water", key: "surface_water"},
        {label: "Population", key: "population"},
        {label: "Created", key: "created"},
        {label: "Edited", key: "edited"},
        {label: "Url", key: "url"}
    ],
    lists: [
        {label: "Residents", key: "residents"},
        {label: "Films", key: "films"}
    ]
};


const PlanetDetails: React.FC = () => {
    const {planetId} = useParams();
    const [planet, setPlanet] = useState<Planet>();
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        const getById = async () => {
            setLoading(true);
            try {
                const response = await fetch(endpoints.planets(planetId as string));
                const result = await response.json();
                setPlanet(result);
            } catch (e) {
                console.error(e);
            } finally {
                setLoading(false)
            }
        }

        getById();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    if (loading) {
        return 'loading';
    }

    if (!planet) {
        return 'planet not found';
    }
    const imagePath = getImagePath(planet.url);

    return (
        <DetailPage entity={planet} entityDetails={planetDetailsConfig} imagePath={imagePath}/>
    );
};

export default PlanetDetails;