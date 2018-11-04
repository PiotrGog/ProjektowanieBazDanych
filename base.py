from sqlalchemy import create_engine

engine = create_engine('mysql://root:password@mysql-dev/project_db')
engine.connect()