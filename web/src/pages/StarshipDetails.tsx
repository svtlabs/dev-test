import React, {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import {getImagePath} from "../components/util.ts";

import DetailPage from "../components/DetailPage.tsx";
import {Starship} from "../components/types.ts";
import {endpoints} from "../components/endpoints.ts";

const starshipDetailsConfig = {
    title: "Starship",
    mainProperty: 'name',
    attributes: [
        {label: "Name", key: "name"},
        {label: "Model", key: "model"},
        {label: "Manufacturer", key: "manufacturer"},
        {label: "Cost in credits", key: "cost_in_credits"},
        {label: "Length", key: "length"},
        {label: "Max atmosphering speed", key: "max_atmosphering_speed"},
        {label: "Crew", key: "crew"},
        {label: "Passengers", key: "passengers"},
        {label: "Cargo capacity", key: "cargo_capacity"},
        {label: "Consumables", key: "consumables"},
        {label: "Hyperdrive class", key: "hyperdrive_rating"},
        {label: "MGLT", key: "MGLT"},
        {label: "Starship class", key: "starship_class"},
        {label: "Created", key: "created"},
        {label: "Edited", key: "edited"},
        {label: "Url", key: "url"}
    ],
    lists: [
        {label: "Pilots", key: "pilots"},
        {label: "Films", key: "films"}
    ]
};

const StarshipDetails: React.FC = () => {
    const {starshipId} = useParams();
    const [starship, setStarship] = useState<Starship>();
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        const getById = async () => {
            setLoading(true);
            try {
                const response = await fetch(endpoints.starships(starshipId as string));
                const result = await response.json();
                setStarship(result);
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

    if (!starship) {
        return 'starship not found';
    }
    const imagePath = getImagePath(starship.url);

    return (
        <DetailPage entity={starship} entityDetails={starshipDetailsConfig} imagePath={imagePath}/>
    );
};

export default StarshipDetails;