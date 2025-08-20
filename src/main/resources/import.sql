INSERT INTO "CrazyAnts".public.project (key, name, description)
SELECT
    'PRJ-' || gs::text,
    'Project ' || gs,
    'Description for project ' || gs
FROM generate_series(1, 100) gs;
