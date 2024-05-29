import {Link} from 'react-router-dom';
import type {Film, People, Planet, Specie, Starship, Vehicle} from './types';
import {EmptyState} from './EmptyState';

function ListLinks(
    {list, label}: { list: People[] | Planet[] | Vehicle[] | Specie[] | Starship[] | Film[], label: string }
) {
    if (list === undefined || list.length === 0) {
        return (<p>
            <strong>{label}</strong>
            <EmptyState/>
        </p>)
    }

    return (
        <p>
            <strong>{label}</strong>

            {list.map((item: People | Planet | Vehicle | Specie | Starship | Film, index: number) => (
                <Link to={`/${item.url}`} key={item.url}>
                    {'title' in item ? item.title : item.name}
                    {index < list.length - 1 && ', '}
                </Link>
            ))}
        </p>


    );
}

export default ListLinks;
