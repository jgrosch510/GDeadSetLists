BEGIN TRANSACTION;
DROP TABLE IF EXISTS "setlists";
CREATE TABLE IF NOT EXISTS "setlists" (
	"rec_num"	INTEGER,
	"rec_id"	TEXT,
	"band"	TEXT,
	"artist_key"	TEXT,
	"show_key"	TEXT,
	"show_date"	TEXT,
	"venue"	TEXT,
	"city"	TEXT,
	"state_abbr"	TEXT,
	"set_1"	TEXT,
	"set_2"	TEXT,
	"set_3"	TEXT,
	"comment"	TEXT,
	"last_update"	TEXT,
	"show_year"	TEXT,
	"show_month"	TEXT,
	"show_day"	TEXT,
	"show_user_id"	TEXT,
	PRIMARY KEY("rec_num" AUTOINCREMENT)
);
DROP TABLE IF EXISTS "shnids";
CREATE TABLE IF NOT EXISTS "shnids" (
	"rec_num"	INTEGER,
	"rec_id"	TEXT,
	"shnid"	TEXT,
	"etree_show_id"	TEXT,
	"recording_type"	TEXT,
	"year"	TEXT,
	"month"	TEXT,
	"day"	TEXT,
	"path"	TEXT,
	PRIMARY KEY("rec_num" AUTOINCREMENT)
);
DROP INDEX IF EXISTS "show_key";
CREATE INDEX IF NOT EXISTS "show_key" ON "setlists" (
	"show_key"
);
DROP INDEX IF EXISTS "rec_id";
CREATE INDEX IF NOT EXISTS "rec_id" ON "setlists" (
	"rec_id"
);
COMMIT;
