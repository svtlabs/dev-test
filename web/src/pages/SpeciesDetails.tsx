import React, {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import {getImagePath} from "../components/util.ts";
import type {Specie} from "../components/types.ts";
import {endpoints} from "../components/endpoints.ts";
import DetailPage from "../components/DetailPage.tsx";

const speciesDetailsConfig = {
    title: "Species",
    mainProperty: 'title',
    attributes: [
        {label: "Title", key: "title"},
        {label: "Episode ID", key: "episode_id"},
        {label: "Opening Crawl", key: "opening_crawl"},
        {label: "Director", key: "director"},
        {label: "Producer", key: "producer"},
        {label: "Release Date", key: "release_date"},
        {label: "Created", key: "created"},
        {label: "Edited", key: "edited"},
        {label: "Url", key: "url"}
    ],
    lists: [
        {label: "Characters", key: "characters"},
        {label: "Planets", key: "planets"},
        {label: "Starships", key: "starships"},
        {label: "Vehicles", key: "vehicles"},
        {label: "Species", key: "species"}
    ]
};

const SpeciesDetails: React.FC = () => {
    const {speciesId} = useParams();
    const [species, setSpecies] = useState<Specie>();
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        const getById = async () => {
            setLoading(true);
            try {
                const response = await fetch(endpoints.species(speciesId as string));
                const result = await response.json();
                setSpecies(result);
            } catch (e) {
                console.error(e);
            } finally {
                setLoading(false)
            }
        }

        getById();
    }, []);

    if (loading) {
        return 'loading';
    }

    if (!species) {
        return 'species not found';
    }
    const imagePath = getImagePath(species.url);

    return (
        <DetailPage entity={species} entityDetails={speciesDetailsConfig} imagePath={imagePath}/>
    );
};

export default SpeciesDetails;