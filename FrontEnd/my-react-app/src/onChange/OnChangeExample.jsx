import {useState} from "react";

function OnChangeExample() {
    const [name, setName] = useState('Guest')
    const [quantity, setQuantity] = useState(0)
    const [comment , setComment] = useState('')
    const [payment , setPayment] = useState('')
    const [shipping , setShipping] = useState('')

    function handleChangeName(e) {
        setName(e.target.value)
    }
    function handleChangeQuantity(e) {
        setQuantity(e.target.value)
    }
    function handleChangeComment(e) {
        setComment(e.target.value)
    }
    function handleChangePayment(e) {
        setPayment(e.target.value)
    }
    function handleChangeShipping(e) {
        setShipping(e.target.value)
    }
    return (
        <div>
            <input type="text" value={name} onChange={handleChangeName}/>
            <p>{name}</p>
            <input type="number" value={quantity} onChange={handleChangeQuantity}/>
            <p>{quantity}</p>
            <textarea value={comment} onChange={handleChangeComment}/>
            <p>{comment}</p>
            <select value={payment} onChange={handleChangePayment}>
                <option value="">Select Payment</option>
                <option value="credit">Credit</option>
                <option value="debit">Debit</option>
                <option value="paypal">Paypal</option>
            </select>
            <p>{payment}</p>
            <input type="radio" value="home" checked={shipping === 'home'} onChange={handleChangeShipping}/>Home
            <input type="radio" value="office" checked={shipping === 'office'} onChange={handleChangeShipping}/>Office
        </div>
    )
}

export default OnChangeExample;