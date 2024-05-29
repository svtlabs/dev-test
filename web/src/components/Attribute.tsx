import {EmptyState} from './EmptyState';

export const Attribute = ({label, value}: { label: string, value: string }) =>
    <p><strong>{label}:</strong> {value || <EmptyState/>}</p>
