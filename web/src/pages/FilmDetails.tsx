import React, {useEffect, useState} from "react";
import {useParams} from 'react-router-dom';
import {getImagePath} from "../components/util.ts";
import type {Film} from "../components/types.ts";
import {endpoints} from "../components/endpoints.ts";
import DetailPage from "../components/DetailPage.tsx";

const filmDetailsConfig = {
    title: "Film",
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

const FilmDetails: React.FC = () => {
    const {filmId} = useParams();
    const [film, setFilm] = useState<Film>();
    const [loading, setLoading] = useState(false);
    useEffect(() => {
        const getFilmById = async () => {
            setLoading(true);
            try {
                const response = await fetch(endpoints.films(filmId as string));
                const result = await response.json();
                setFilm(result);
            } catch (e) {
                console.error(e);
            } finally {
                setLoading(false)
            }
        }

        getFilmById();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    if (loading) {
        return 'loading';
    }

    if (!film) {
        return 'film not found';
    }

    const imagePath = getImagePath(film.url);

    return (
        <DetailPage entity={film} entityDetails={filmDetailsConfig} imagePath={imagePath}/>
    );
};

export default FilmDetails;