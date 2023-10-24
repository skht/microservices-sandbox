from fastapi import FastAPI
from os import listdir
from os.path import isfile, join

app = FastAPI()

path = "test_dir"

@app.get("/list_files")
async def list_files_rest():
    return await list_files()

@app.get("/read_file/{name}")
async def read_file_rest(name):
    return await read_file_content(name)

async def list_files():
    return [f for f in listdir(path) if isfile(join(path, f))]

async def read_file_content(filename):
    return f"Reading file with the {filename}"