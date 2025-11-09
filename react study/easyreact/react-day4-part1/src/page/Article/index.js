import { useSearchParams, useParams } from "react-router-dom"

const Article = () => {
    // const[params] = useSearchParams();
    // const id = params.get('id');
    // get传参


    const params = useParams();
    const id = params.id
    //param传参
    return <div>我是文章页</div>
}

export default Article